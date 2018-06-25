package exams;

public class _ConstructorExam
{

    _IExam iExam;

    public _ConstructorExam(_IExam iExam) {
        this.iExam = iExam;
    }

    public void getTestExam(_ConstructorExam constructorExam){
        constructorExam.iExam.getExamList();
    }
}
