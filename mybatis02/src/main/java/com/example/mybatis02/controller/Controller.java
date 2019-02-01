package com.example.mybatis02.controller;


import com.example.mybatis02.ConstantsCodeEnum;
import com.example.mybatis02.bean.ResultMessage;
import com.example.mybatis02.bean.UserBean;
import com.example.mybatis02.dao.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @RequestMapping(value="/",method=RequestMethod.GET)
    public String helloworld(){
        return "get hello world";

    }


    @RequestMapping(value="/",method=RequestMethod.POST)
    public String posthttp(){
        return "post hello world";

    }


     private boolean isNotNull(@RequestParam(value = "account", required = true) String account,
                              @RequestParam(value = "password", required = true) String password,
                              ResultMessage resultMessage) {
        if (account == null || account.equals("")){
            resultMessage.raise(ConstantsCodeEnum.ACCOUNT_NULL.getCode(),ConstantsCodeEnum.ACCOUNT_NULL.getName());
            return true;
        }else if(password == null || password.equals("")){
            resultMessage.raise(ConstantsCodeEnum.PASSWORD_NULL.getCode(),ConstantsCodeEnum.PASSWORD_NULL.getName());
            return true;
        }
        return false;
    }

    @Autowired
    private LoginMapper loginMapper;
    /**
     * http://blog.csdn.net/u010399316/article/details/52913299
     */
    @RequestMapping(value = "/loginbypost", method = RequestMethod.POST)
    public Object loginByPost(@RequestParam(value = "account", required = true) String account,
                              @RequestParam(value = "password", required = true) String password) {
        System.out.println("hello post"+":name:"+account);
        System.out.println("hello post"+":pwd:"+password);

        ResultMessage resultMessage = ResultMessage.create();


        /*判断账号密码是否输入空值*/
        if (isNotNull(account, password, resultMessage)) return resultMessage;

        UserBean login = this.loginMapper.getByName(account);
        if (login == null){
            resultMessage.raise(ConstantsCodeEnum.INEXISTENCE.getCode(),ConstantsCodeEnum.INEXISTENCE.getName());
            return resultMessage;
        }else{
            System.out.println(login.toString());
            if (login.getPassword().equals(password) ){
                resultMessage.put("name",account);
                resultMessage.put("pwd",password);
                resultMessage.raise(ConstantsCodeEnum.SUCCESS.getCode(),ConstantsCodeEnum.SUCCESS.getName());
            }else{
                resultMessage.raise(ConstantsCodeEnum.PASSWORD_INCORRECT.getCode(),ConstantsCodeEnum.PASSWORD_INCORRECT.getName());
            }

            return resultMessage;
        }
    }

    @RequestMapping(value = "/registerAccountByPost", method = RequestMethod.POST)
    public Object registerAccountByPost(@RequestParam(value = "account", required = true) String account,
                                        @RequestParam(value = "password", required = true) String password) {
        System.out.println("注册name:"+account+"，pwd:"+password);

        ResultMessage resultMessage = ResultMessage.create();

        /*判断账号密码是否输入空值*/
        if (isNotNull(account, password, resultMessage)) return resultMessage;

        UserBean userBean = this.loginMapper.getByName(account);
        if (userBean != null){
            resultMessage.raise(ConstantsCodeEnum.ACCOUNT_ALREADY_EXIST.getCode(), ConstantsCodeEnum.ACCOUNT_ALREADY_EXIST.getName());
            return resultMessage;
        }else{
            resultMessage.put("name",account);
            resultMessage.put("pwd",password);
            resultMessage.raise(ConstantsCodeEnum.SUCCESS.getCode(),ConstantsCodeEnum.SUCCESS.getName());

            userBean = new UserBean();
            userBean.setAccount(account);
            userBean.setPassword(password);
            int registerUser = this.loginMapper.register(userBean);
            System.out.println("注册成功："+registerUser);
            return resultMessage;
        }
    }



}
