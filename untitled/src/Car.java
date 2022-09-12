public class Car
{
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String colour;

    public void setModel(String model)
    {
        String val_model = model.toLowerCase();
        if(val_model.equals("porsche") || val_model.equals("commodore"))
        {
            this.model = model;
        }
        else{
            this.model = "Unknown";
        }
    }

    public String getModel()
    {
        return this.model;
    }
}
