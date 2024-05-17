import styles from "./LoginPage.module.css";
import { useState } from 'react';
import { useNavigate } from "react-router-dom";

function LoginPage() {
  const navigate = useNavigate();

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = () => {
    // Implement your login logic here (e.g., API calls, authentication)
    console.log('Logging in with:', username, password);
    // Redirect to the dashboard or home page after successful login
    navigate("/admin");
  };

  return (
    <div className={styles.loginContainer}>
      <form className={styles.loginForm}>
        <h1>Connexion</h1>
        <input
          type="text"
          placeholder="Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <p className={styles.info}>Pas encore inscrit(e) <a href="/register">S'inscrire</a></p>
        <button onClick={handleLogin}>Se connecter</button>
      </form>
    </div>
  );
}

export default LoginPage