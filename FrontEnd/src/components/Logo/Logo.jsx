import styles from './Logo.module.css';

//images
import Icon from "../../assets/images/graduation-hat.png";
import curve from "../../assets/images/headline-curve.svg";

function Logo() {

  return (
    <div className={styles.container}>
      <a href="/">
        <div className={styles.logo}>
          <img src={Icon} alt="ZLearning logo" />
          ZLearning
        </div>
        <img className={styles.curve} src={curve} alt="curve line" />
      </a>
    </div>
  )
}

export default Logo
