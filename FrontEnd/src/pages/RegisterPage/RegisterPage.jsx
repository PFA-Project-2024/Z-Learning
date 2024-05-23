import styles from "./RegisterPage.module.css";
import { useState } from 'react';

//components
import Logo from "../../components/Logo/Logo";

function RegisterPage() {
  const [lastName, setLastName] = useState('');
  const [firstName, setFirstName] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleRegister = () => {
    // Implement your registration logic here (e.g., API calls, validation)
    console.log('Registering user:', fullName, email, password);
    // Redirect to the login page after successful registration
  };

  return (
    <div className={styles.registrationContainer}>
      <Logo />
      <form className={styles.registrationForm}>
        <h1>Inscription</h1>
        <input
          type="text"
          placeholder="Nom"
          value={lastName}
          onChange={(e) => setLastName(e.target.value)}
        />
        <input
          type="text"
          placeholder="Prénom"
          value={firstName}
          onChange={(e) => setFirstName(e.target.value)}
        />
        <input
          type="tel"
          placeholder="Numéro de téléphone"
          value={phoneNumber}
          onChange={(e) => setPhoneNumber(e.target.value)}
        />
        <input
          type="email"
          placeholder="Adresse e-mail"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <input
          type="password"
          placeholder="Mot de passe"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <p className={styles.info}>Déjà inscrit(e) <a href="/login">Se connecter</a></p>
        <button onClick={handleRegister}>S'inscrire</button>
      </form>
    </div>
  );
}

export default RegisterPage