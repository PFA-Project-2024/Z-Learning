import styles from "./ProfilePage.module.css";
import { useState } from 'react';

//Components
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";

function ProfilePage() {
  return (
    <>
    <Header />

    <div className={styles.container}>
      Profile Page
    </div>
    
    <Footer />
    </>
  );
}

export default ProfilePage