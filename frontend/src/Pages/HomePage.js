import { React, useState, useEffect } from "react";
import { Space, Table, Tag, Popconfirm } from "antd";
import { useNavigate } from "react-router-dom";
import "../App.css"



function HomePage(props) {
    const [datasource, setDatasource] = useState([])
    const [count, setCount] = useState()
    const navigate = useNavigate();


    useEffect( () => {
        async function getRecords() {
          const response = await fetch("/api/users")
          if(!response.ok) {
            console.log("Error:" + response.statusText);
            return;
          }
          const res = await response.json();
          console.log(res);
          setCount(res.length)
          setDatasource('')
          setDatasource(res);
          console.log(res.length)
        }
        getRecords();

        return;
    }, [count]);


    const columns = [
        {
            title: 'Username',
            dataIndex: 'username',
            key: 'username',
        },
        {
            title: 'Email',
            dataIndex: 'email',
            key: 'email',
        },
        {
            title: 'Action',
            key: 'action',
            render: (_, record) => (
                <Space size="middle">
                {/* <a>Edit</a> */}
                <Popconfirm title="Sure to delete?" onConfirm={() => handleDelete(record)}>
                    <a>Delete</a>
                </Popconfirm>
                </Space>
            ),
        },
    ];


    const handleDelete = async (record) => {
        console.log(record.id)
        async function deleteData() {
            const response = await fetch("/api/users/" + record.id, {
                  method: "DELETE",
                  headers: {
                    "Content-Type": "application/json",
                  },
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
                console.log(count);
                setCount(setCount - 1)
                console.log(count);
                navigate('/');
            }

            }
        await deleteData().catch(console.error);
      };

    return (
        <div className="usertable">
            <Table columns={columns} dataSource={datasource} />
        </div>
    );
};


export default HomePage;
