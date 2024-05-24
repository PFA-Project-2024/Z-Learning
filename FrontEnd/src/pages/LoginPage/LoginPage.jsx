import styles from "./LoginPage.module.css";
import { useState } from 'react';
import { useNavigate } from "react-router-dom";
import Cookies from "js-cookie";

//components
import Logo from "../../components/Logo/Logo";

function LoginPage() {
  const navigate = useNavigate();

  const [user, setUser] = useState({
    email: "",
    password: ""
  })

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setUser({ ...user, [name]: value });
  };

  const handleLogin = (e) => {
    e.preventDefault();

    console.log('Logging in with:', user);
    SetCookie("user", JSON.stringify(user), 1);

    // if(user.isAdmin)
    // {
    //   navigate("/admin");
    // }else
      navigate("/");
  };

  const SetCookie = (key, value, expireDays) => {
    Cookies.set(key, value, {
      expires: expireDays,
    });
  };

  const GetCookie = (key) => {
    alert(Cookies.get(key));
  };

  return (
    <div className={styles.loginContainer}>
      <Logo />
      <form className={styles.loginForm}>
        <h1>Connexion</h1>
        <input
          type="text"
          name="email"
          placeholder="Email"
          value={user.email}
          onChange={handleInputChange}
        />
        <input
          type="password"
          name="password"
          placeholder="Password"
          value={user.password}
          onChange={handleInputChange}
        />
        <p className={styles.info}>Pas encore inscrit(e) <a href="/register">S'inscrire</a></p>
        <button onClick={handleLogin}>Se connecter</button>
      </form>
    </div>
  );
}

export default LoginPage