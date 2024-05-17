import styles from "./CoursePage.module.css";

import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import ReactPlayer from 'react-player';
import axios from 'axios';

//components
import Header from '../../components/Header/Header';
import Footer from '../../components/Footer/Footer';
import PopUp from "../../components/PopUp/PopUp";

//utils
import { ratingStars, formatDate } from "../../utils/helpers";

//images
import placeholder from "../../assets/images/placeholder.png";
import profileHolder from "../../assets/images/profile.png";

function CoursesPage() {
  const params = useParams();
  const [pop, setPop] = useState(false);
  const [id, setId] = useState('');

  const [course, setCourse] = useState({
    id: "66477b73e066da7225cadba7",
    title: "Master en sciences de l'environnement",
    description: "Le Master en sciences de l’environnement est un programme d’études supérieures axé sur l’étude approfondie des interactions entre l’environnement naturel et les activités humaines. Ce diplôme permet aux étudiants d’acquérir des connaissances avancées dans des domaines tels que la gestion des ressources naturelles, la conservation de la biodiversité, la durabilité environnementale et les politiques environnementales. Les diplômés du Master en sciences de l’environnement sont bien préparés pour des carrières dans la recherche, la gestion environnementale, la consultation et l’éducation.",
    mainImagePath: "https://images.pexels.com/photos/4348404/pexels-photo-4348404.jpeg",
    price: 599.99,
    startDate: "2024-04-10T00:00:00.000+00:00",
    instructorName: "Anwar Fernari",
    endDate: "2025-05-16T00:00:00.000+00:00",
    categoryName: "Science",
    rating: 4,
    videoUrl: "https://www.youtube.com/watch?v=Znzq_a3nasY",
    quizUrl: "",
    url: null
  });

  const setScroll = (val) => {
    document.body.style.overflow = val ? 'scroll' : 'hidden';
  }

  const enroll = () => {
    setScroll(false);
    setPop(true);
  }

  const popUpOK = () => {
    setScroll(true);
    setPop(false);
  }

  const popUpCancel = () => {
    setScroll(true);
    setPop(false);
  }

  useEffect(() => {
    if (params.id) {
      setId(params.id);
    }

    const fetchData = async () => {
      try {
        const val = await axios.get(`http://localhost:8080/admin/courses/${params.id}`);
        setCourse(val.data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, []);

  return (
    <>
      <Header />
      <div className={styles.container}>
      <div className={styles.main}>
          <div className={styles.navPath}>
            <a href="/courses">Courses</a> / <a href={`/courses/${course.categoryName}`}>{course.categoryName}</a> / <b>{course.title}</b>
          </div>
          <div className={styles.courseContainer}>
            <h1>{course.title}</h1>
            <p>{course.categoryName}</p>
            <img
              className={styles.courseImage}
              src={course.mainImagePath ? course.mainImagePath : placeholder}
              alt="Course Thumbnail"
            />
            <h3>À propos de ce cours</h3>
            <p>{course.description}</p>
          </div>
          {course.videoUrl &&
            <div className={styles.courseVideo}>
              <h3>Enregistrement vidéo du cours</h3>
              <ReactPlayer
                url={course.videoUrl}
                width="100%"
                height="100%"
                controls />
            </div>
          }
        </div>
        <div className={styles.side}>
          {/* Course Info */}
          <div className={styles.enrollCard}>
            <h4>Informations sur le cours</h4>
            <div className={styles.courseRating}>
              {ratingStars(course.rating)}
            </div>
            <p><i>{formatDate(course.startDate)}</i> à <i>{formatDate(course.endDate)}</i></p>
            <p className={styles.coursePrice}>{course.price} Dhs</p>
            <button className={styles.courseButton} onClick={enroll}>S'inscrire à ce cours</button>

            {pop &&
              <PopUp title="S'inscrire à ce cours"
                description="Êtes-vous sûr de vouloir vous inscrire à ce cours ?"
                OK={popUpOK}
                CANCEL={popUpCancel} />
            }
          </div>

          {/* Instructor */}
          <div className={styles.intructorCard}>
            <h4>À propos de l’instructeur</h4>
            <div className={styles.intructorInfo}>
              <div className={styles.intructorImageContainer}>
                <img className={styles.intructorImage}
                  // src={course.instructor.image ? course.instructor.image : profileHolder}
                  src={profileHolder}
                  alt="instructor profile" />
              </div>
              <div>
                <p className={styles.intructorName}>Instructor name</p>
                <p className={styles.intructorTagline}>Instructor departement</p>
              </div>
            </div>
            <p>description about the instructor</p>
          </div>

          {/* Quiz */}
          <div className={styles.quizCard}>
            <h4>Final Quiz</h4>
            <p>Passez cet Quiz pour prouver que vous avez obtenu des informations essentielles de ce cours.</p>
            <a href={course.quizUrl} target="_blank">
              <button className={styles.courseButton}>Lancer le quiz</button>
            </a>
          </div>
        </div>
      </div>
      <Footer />
    </>
  )
}

export default CoursesPage