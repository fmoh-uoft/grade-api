package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

import java.lang.reflect.Member;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        Team myTeam = gradeDB.getMyTeam();
        String[] members = myTeam.getMembers();
        int count = members.length;
        float total_grade = 0;

        for (String member: members){
            Grade grade = gradeDB.getGrade(member, course);
            total_grade += grade.getGrade();

        }

        return total_grade / count;
    }
}
