import java.util.ArrayList ;
import androidx.recyclerview.widget.RecyclerView;

public class BMIAdapter  {
    private ArrayList<BMIdata> bmIdataList;

    public BMIAdapter(ArrayList<BMIdata> bmIdataList) {
        this.bmIdataList = bmIdataList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

    }

}