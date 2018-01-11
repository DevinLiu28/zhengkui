package com.lanou3g.bookstore.user.service;

import com.lanou3g.bookstore.user.dao.Userdao;
import com.lanou3g.bookstore.user.domain.User;
import com.lanou3g.bookstore.user.service.exception.*;
import com.lanou3g.bookstore.util.RandomId;

import java.util.UUID;

public class UserService {
    private Userdao userdao = new Userdao();
    public User regist(User form) throws RepetitiveUsernameException, RepetitiveEmainException, NotUsernameException, NotPasswordException, NotEmail {
        if (form.getUsername().equals("")){
            throw new NotUsernameException();
        }else if (form.getPassword().equals("")){
            throw new NotPasswordException();
        }else if (form.getEmail().equals("")){
            throw new NotEmail();
        }else {
            User byUsername = userdao.findByUsername(form.getUsername());
            User byEmail = userdao.findByEmail(form.getEmail());

            if (byUsername!=null){
                //已经存在用户名;提示用户注册失败;用户名重复
                throw new RepetitiveUsernameException();
            }else if(byEmail!=null) {
                //邮箱已存在;提示用户注册失败;邮箱重复
                throw new RepetitiveEmainException();
            }else {
                //登录成功;补全用户信息

                form.setUid(RandomId.randomId());
                form.setPower(0);
                UUID uuid = UUID.randomUUID();
                form.setCode(uuid.toString());
                userdao.add(form);
            }
            return form;
        }
    }

    public String request(String code){
        User byCode = userdao.findByCode(code);
        if (byCode==null){
            //无此用户
            return "没有此用户";
        }else if (byCode.getState()==1){
            //已经激活
           return "此用户已经激活";
        }else {
            userdao.updateState(byCode.getUid(),1);
            return "激活成功";
        }
    }

    public User login(User form) throws UserException {
        User user = userdao.findByUsername(form.getUsername());
//        System.out.println(user.getState());
        if(user==null){
            //用户名不存在
            throw new InexistenceUsernameException();
        }else if (form.getPassword().equals(user.getPassword())){
            //判断是否激活
            if (user.getState()==0){
                //没激活;不能登录
                throw new NonactivatedException();
            }else {
                //登录成功
                return user;
            }
        } else {
            //密码错误;抛出异常
            throw new PasswordNotMatchedException();
        }

    }
}
