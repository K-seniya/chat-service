import React, {Component} from 'react';
import Footer from './footer/Footer'
import './ChatBox.css';
import './aside/Aside.css'
import Room from "./menu-app-bar/Room";
import Login from "./login/Login";


export default class RoomBoardComponent extends Component {
    constructor(props) {
        super(props);
        this.state =
            {
                rooms: [],
                isLoginCrashed: false,
                isLoginMode: false,
                user: '',
                password: '',
                room: ''
            };
    }


    componentDidMount() {
        fetch("http://localhost:8080/rooms/")
            .then(res => res.json())
            .then(
                (result) => {
                    this.setState({
                        rooms: result
                    });
                },
                (error) => {
                    console.log("got error" + error);
                    this.setState({
                        error: 'Could not get rooms!'
                    });
                }
            )
    }

    enterRoom = (room, user, password) => {
        console.log(room, user, password);

        this.setState({
            isLoginMode: true,
            room: room,
            user: user,
            password: password
        });
         };

    connectionEstablished = (isSuccess, client) => {
        if (isSuccess) {
            this.setState({
                isLoginMode: false,
                isLoginCrashed: false
            });
            this.props.onRoomLogin(this.state.room, this.state.user, client);
        } else {
            this.setState({
                isLoginMode: false,
                isLoginCrashed: true
            });
        }

    };


    render() {
        let view = this.state.isLoginMode ?
            (<Login connect={this.connectionEstablished} password={this.state.password} room={this.state.room}
            user={this.state.user}/>) :
            (
                <div id="container">
                    {this.state.isLoginCrashed ? (<div> Password is incorrect </div>) : (<span/>)}
                    <div>
                        <aside>
                            <div className="vr"></div>
                            <ul>
                                {this.state.rooms.map((room, i) =>
                                    <li key={i}>
                                        <Room room={room} onRoomEntered={this.enterRoom}/>
                                    </li>
                                )}
                            </ul>
                        </aside>
                        <ul id="chat" ref="messageBox"></ul>
                        <div></div>
                        <Footer/>
                    </div>
                </div>
            );
        return view;
    }
}