import React from 'react';

const LoginPage = () => {
    const handleButtonClick = () => {
        window.location.href = 'http://localhost:8080/oauth/kakao';
    };

    const containerStyle = {
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        justifyContent: 'center',
        height: '100vh',
    };

    const titleStyle = {
        fontSize: '40px',
        fontWeight: 'bold',
        marginBottom: '20px',
    };

    const buttonStyle = {
        padding: '20px 40px',
        fontSize: '24px',
        borderRadius: '5px',
        cursor: 'pointer',
        backgroundColor: '#FEE500', 
        color: 'black', 
        border: 'none', 
        fontWeight: 'bold', 
    };

    return (
        <div style={containerStyle}>
            <h1 style={titleStyle}>OAuth 2.0</h1>
            <button
                onClick={handleButtonClick}
                style={buttonStyle}
            >
                카카오톡 로그인
            </button>
        </div>
    );
};

export default LoginPage;
