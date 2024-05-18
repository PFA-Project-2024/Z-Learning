import styles from "./Course.module.css";
import { useState, useEffect } from 'react';
import axios from 'axios';

import Carousel from 'react-multi-carousel';
import 'react-multi-carousel/lib/styles.css';

//Components
import CourseCard from "../CourseCard/CourseCard";

const responsive = {
  desktop: {
    breakpoint: { max: 3000, min: 1024 },
    items: 3,
    slidesToSlide: 3
  },
  tablet: {
    breakpoint: { max: 1024, min: 464 },
    items: 2,
    slidesToSlide: 2
  },
  mobile: {
    breakpoint: { max: 464, min: 0 },
    items: 1,
    slidesToSlide: 1
  }
};

function Course() {
  const [courses, setCourses] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const val = await axios.get('http://localhost:8080/admin/courses');
        setCourses(val.data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, [courses]);

  return (
    <div id="courses" className={styles.container}>
      <div className={styles.title}>
        <h2>Cours les plus populaires</h2>
        <p>“Un apprentissage fluide pour tous, où que vous soyez” 🌐</p>
      </div>

      <Carousel responsive={responsive}>
        {courses.map((course) => (
          <div key={course.id} className={styles.courseCardWrapper}>
            <CourseCard courseId={course.id} title={course.title} desctiption={course.description}
              price={course.price} category={course.categoryName} rating={course.rating} 
              image={course.mainImagePath} url={course.URL} />
          </div>
        ))}
      </Carousel>
    </div>
  )
}

export default Course
