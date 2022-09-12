public class Button {
    private String title;
    private OnClickListener onClickListener;

     public Button(String title)
     {
         this.title = title;
     }

    public String getTitle() {
        return title;
    }

    public void setOnClickListener(OnClickListener on)
    {
        this.onClickListener = on;
    }

    public void onclick()
    {
        this.onClickListener.onclick(this.title);
    }
    public interface OnClickListener{
        public void onclick(String title);
    }
}
