import styles from "./ProfilePage.module.css";

//Components
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";

function ProfilePage() {
  return (
    <>
    <Header />

    <div className={styles.container}>
            <div className={styles.card}>
                <div className={styles.cardBody}>
                    <div className={styles.profilePicContainer}>
                        <img 
                            src="https://bootdey.com/img/Content/avatar/avatar7.png" 
                            alt="User" 
                            className={styles.profilePic} 
                        />
                    </div>
                    <div className={styles.userDetails}>
                        <h2 className={styles.userName}>John Doe</h2>
                        <p className={styles.userDetail}>Full Name:</p>
                        <div className={styles.userdata}>
                        <p className={styles.userDetail}>John Doe</p>
                        </div>
                        <p className={styles.userDetail}>Email:</p>
                        <div className={styles.userdata}>
                        <p className={styles.userDetail}>johndoe@example.com</p>
                        </div>
                        <p className={styles.userDetail}>Phone:</p>
                        <div className={styles.userdata}>
                        <p className={styles.userDetail}>+212 1234-7890</p>
                        </div>
                        <p className={styles.userDetail}>Mot de passe:</p>
                        <div className={styles.userdata}>
                        <p className={styles.userDetail}>••••••••</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    
    
    <Footer />
    </>
  );
}

export default ProfilePage
