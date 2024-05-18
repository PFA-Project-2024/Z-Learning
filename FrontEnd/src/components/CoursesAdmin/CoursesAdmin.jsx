import styles from "./CoursesAdmin.module.css";
import { useState, useEffect } from "react";
import axios from 'axios';

//components
import MyTable from "../MyTable/MyTable";
import CourseForm from "../CourseForm/CourseForm";

function CoursesAdmin() {
  const [formOpen, setFormOpen] = useState(false);

  const [courses, setCourses] = useState([]);

  const [courseData, setCourseData] = useState({
    id: '',
    title: '',
    image: '',
  });

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

  const setScroll = (val)=>{
    document.body.style.overflow = val ? 'scroll' : 'hidden';
  }

  const addCourse = ()=>{
    setScroll(false);
    setFormOpen(true);
  }

  const onAdd = ()=>{
    setScroll(true);
    setFormOpen(false);
  }

  const onCancel = ()=>{
    setScroll(true);
    setFormOpen(false);
  }

  const onEdit = (item) => {
    alert("Updating...\n" + item.title);
  }

  const onDelete = (id) => {
    alert(`Deleting ${id} ...`);
  }

  return (
    <div className={styles.container}>
      <div className={styles.header}>
        <h3>Courses</h3>
        <button className="btn-v2" onClick={addCourse}>+ Ajouter un cours</button>
      </div>
      <div className={styles.body}>
        <MyTable data={courses} onEdit={onEdit} onDelete={onDelete} />
      </div>

      {formOpen && 
        <CourseForm ADD={onAdd} CANCEL={onCancel}/>
      }
    </div>
  )
}

export default CoursesAdmin
