import React from 'react';

const LoginSuccess = () => {
    const containerStyle = {
        backgroundColor: 'white', // 흰색 배경
        height: '100vh',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center'
    };

    const contentStyle = {
        backgroundColor: '#FEE500', // 카카오톡의 노란색
        padding: '40px 60px',
        borderRadius: '10px', // 둥근 모서리
        textAlign: 'center',
        boxShadow: '0px 4px 8px rgba(0, 0, 0, 0.1)', // 그림자 효과
        maxWidth: '400px' // 최대 너비
    };

    return (
        <div style={containerStyle}>
            <div style={contentStyle}>
                <h1>로그인 성공</h1>
            </div>
        </div>
    );
};

export default LoginSuccess;
