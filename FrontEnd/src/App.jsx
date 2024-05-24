import './App.css'
import Cookies from "js-cookie";

import Header from './components/Header/Header';
import Footer from './components/Footer/Footer';

import HomePage from './pages/HomePage/HomePage';


function App() {
  const GetCookie = (key) => {
    const cookieValue = Cookies.get(key);

    try {
      const jsonValue = JSON.parse(cookieValue);
      return jsonValue;
    } catch (e) {
      console.error("Cookie value is not valid JSON", e);
      return false;
    }
  };

  return (
    <>
      <Header user={GetCookie("user")} />
      <HomePage />
      <Footer />
    </>
  )
}

export default App
