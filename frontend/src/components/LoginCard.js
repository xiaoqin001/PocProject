import { React, useState } from "react";
import { Button, Form, Input } from "antd";
import { useNavigate } from "react-router-dom";
import "../App.css"





function LoginCard(props) {

    const [params, setParams] = useState({
        username:'',
        password:''
    })

    const navigate = useNavigate();

    // const onFinish = (values) => {
    //     console.log('Success:', values);
    // };
    // const onFinishFailed = (errorInfo) => {
    //     console.log('Failed:', errorInfo);
    // };

    const onSubmit = async (e)=> {
        e.preventDefault();
        let test={...params}
        setParams(test)
        await requestData(test)
    }

    const requestData= async (params)=>{
        // edited for development and deployment usage
        async function fetchData() {


            const response = await fetch("/api/login", {
                  method: "POST",
                  headers: {
                    "Content-Type": "application/json",
                  },
                   body: JSON.stringify(params),
                })
                .catch(error => {
                  window.alert(error);
                  return;
                });

            if(!response.ok) {
              const message = "An error occured"
              console.log("Error:" + response.statusText);
              return;
            } else {
                navigate('/');

            }

            }
        await fetchData().catch(console.error);


    }

    return (
      <div className="logincard">
        <Form
        name="basic"
        labelCol={{
          span: 8,
        }}
        wrapperCol={{
          span: 16,
        }}
        style={{
          maxWidth: 600,
        }}
        initialValues={{
          remember: true,
        }}
        // onFinish={onFinish}
        // onFinishFailed={onFinishFailed}
        autoComplete="off"
      >
        <Form.Item
          label="Username"
          name="username"
          rules={[
            {
              required: true,
              message: 'Please input your username!',
            },
          ]}
        >
          <Input
            onChange={e => {params.username = e.target.value}}
            value={params.username}
          />
        </Form.Item>

        <Form.Item
          label="Password"
          name="password"
          rules={[
            {
              required: true,
              message: 'Please input your password!',
            },
          ]}
        >
          <Input.Password
                onChange={e => {params.password = e.target.value}}
                value={params.password}
          />
        </Form.Item>

        <Form.Item
          wrapperCol={{
            offset: 8,
            span: 16,
          }}
          className='buttons'
        >
          <Button className='submit' type="primary" htmlType="submit" onClick={onSubmit}>
            Submit
          </Button>
        </Form.Item>
      </Form>
      </div>
    );

};

export default LoginCard;
