import React, {Component} from 'react';
import './Login.css'
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';

export default class Login extends Component {
    constructor(props) {
        super(props);
    }

    componentDidMount () {
        let password = this.props.password;
        let room = {
            name: this.props.room,
            password: password === "" ? null : password
        };

        fetch('http://localhost:8080/room/', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(room)
        })
            .then(
                (result) => {
                    result.status === 200 ?  this.props.connect(true): this.props.connect(false);
                },
                (error) => {
                    console.log("got error" + error);
                }
            )

    }

    render() {
        return (
            <div className="component-Login">
                Checking password
            </div>
        )
    }
}
