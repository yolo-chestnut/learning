package priv.yolo.chestnut.interview.dvt.unknown;

public class BasePo {

    private Long id;

    private String name;

    public BasePo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        BasePo basePo = (BasePo) obj;
        return id == basePo.getId() && name.equals(basePo.getName());
    }

//    @Override
//    public int hashCode() {
//        return id.hashCode() + name.hashCode();
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
