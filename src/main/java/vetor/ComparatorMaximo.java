package vetor;

import java.util.Comparator;

public class ComparatorMaximo implements Comparator<Aluno> {

    @Override
    public int compare(Aluno aluno1, Aluno aluno2) {
        return (int) (aluno1.getMedia() - aluno2.getMedia());
    }
}
