package com.forum.common.shiro;

import com.forum.common.model.ResultModel;
import com.forum.common.model.Token;
import com.forum.common.utils.JWTUtil;
import com.forum.common.utils.ObjectUtil;
import com.forum.repository.domain.User;
import com.forum.repository.mapper.UserMapper;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShrioRealm extends AuthorizingRealm {

    Logger logger = LoggerFactory.getLogger(ShrioRealm.class);

    @Autowired
    private UserMapper userMapper;


    public String login(String code, String password) throws Exception {
        logger.warn("username====================>" + code);
        logger.warn("password====================>" + password);

        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("A10002", "123456");
            usernamePasswordToken.setRememberMe(true);
            try {
                subject.login(usernamePasswordToken);
            } catch (Exception e) {
                logger.warn("认证失败！：" + code);
                throw new Exception("认证失败" + e.getMessage());
            }
        }
        Session session = SecurityUtils.getSubject().getSession();
        Token token = new Token();
        token.setUserId((Long) session.getAttribute("id"));
        session.stop();
       /* return ResultModel.getSuccessResultModel((Object) JWTUtil.sign(token));*/
        return "redirect:/list.jsp";

    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       System.out.println("doGetAuthorizationInfo=====================>");
        String userName=(String) SecurityUtils.getSubject().getPrincipal();
        logger.warn("userName=====================>"+userName);
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        User user = new User();
        user.setAccount(username);
        user.setIsDel(false);
        PageList<User> users = userMapper.selectObjectListByWhere(user, new PageBounds());
        SimpleAuthenticationInfo info = null;
        if (!ObjectUtil.isNull(users)) {
            ByteSource byteSource = ByteSource.Util.bytes(users.get(0).getSalt());
            logger.warn("ByteSource====================>" + byteSource.toHex());
            String realm = getName();
            info = new SimpleAuthenticationInfo(user.getAccount(), users.get(0).getPassword(), byteSource, realm);
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("id", users.get(0).getPkUserId());
        }
        return info;
    }


}
