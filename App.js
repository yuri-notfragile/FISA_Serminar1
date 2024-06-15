import { BrowserRouter, Routes, Route } from 'react-router-dom';
import LoginPage from "./LoginPage";
import LoginSuccess from './LoginSuccess';
import KakaoRedirectPage from "./KakaoRedirectPage";

const App = () => {
  return (
      <div className='App'>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<LoginPage />}></Route>
            <Route path="/oauth/redirected/kakao" element={<KakaoRedirectPage />}></Route>
            <Route path="/success" element={<LoginSuccess />} />
          </Routes>
        </BrowserRouter>
      </div>
  );
};

export default App;