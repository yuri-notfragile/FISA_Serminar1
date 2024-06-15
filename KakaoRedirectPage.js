import React, { useState, useEffect } from 'react';
import {useLocation, useNavigate} from 'react-router-dom';
import axios from 'axios';
import Modal from './CodeDisplay'

const KakaoRedirectPage = () => {
    const location = useLocation();
    const navigate = useNavigate();
    const [authCode, setAuthCode] = useState(null);
    const [isModalOpen, setIsModalOpen] = useState(false);

    const handleOAuthKakao = async (code) => {
        setIsModalOpen(false);
        try {
            // 카카오로부터 받아온 code를 서버에 전달하여 카카오로 회원가입 & 로그인한다
            const response = await axios.get(`http://localhost:8080/oauth/login/kakao?code=${code}`);
            const data = response.data; // 응답 데이터
            //alert("로그인 성공");
            navigate("/success");
        } catch (error) {
            navigate("/fail");
        }
    };

    useEffect(() => {
        const searchParams = new URLSearchParams(location.search);
        const code = searchParams.get('code');  // 카카오는 Redirect 시키면서 code를 쿼리 스트링으로 준다.
        if (code) {
            setAuthCode(code);
            setIsModalOpen(true); // 인증 코드가 있을 때 모달 열기
            setTimeout(() => { // 모달을 몇 초간 보여준 후에 로그인 처리
                handleOAuthKakao(code);
            }, 3000);
        }
    }, [location]);

    return (
        <div>
            {isModalOpen && <Modal code={authCode} onConfirm={() => setIsModalOpen(false)} />}
            <div>Processing...</div>
        </div>
    );
};

export default KakaoRedirectPage;