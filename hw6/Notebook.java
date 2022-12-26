import java.util.Objects;

public class Notebook {
    private final String producer;
    private final String storageType;
    private final int storageCapacity;
    private final int ram;
    private final int diagonal;
    private int qty;

    public void addQty() {
        this.qty++;
    }

    Notebook(String producer, String storageType, int storageCapacity, int ram, int diagonal) {
        this.producer = producer;
        this.storageType = storageType;
        this.storageCapacity = storageCapacity;
        this.ram = ram;
        this.diagonal = diagonal;
        this.qty += 1;
    }

    public String getProducer() {
        return producer;
    }

    public String getStorageType() {
        return storageType;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public int getRam() {
        return ram;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public int getQty() {
        return qty;
    }

    @Override
    public String toString() {
        return "Notebook: |" + this.getProducer() + " " + this.getStorageType() + " "
                + this.getStorageCapacity() + " GB " + this.getRam() + "GB RAM " + this.getDiagonal() +
                "| --> At stock : " + this.getQty() +"pcs";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getProducer(), this.getStorageType(),
                this.getStorageCapacity(), this.getRam(), this.getDiagonal());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Notebook){
            return this.getProducer().equals(((Notebook)obj).getProducer()) &&
                    this.getStorageType().equals(((Notebook)obj).getStorageType()) &&
                    this.getStorageCapacity()==(((Notebook)obj).getStorageCapacity()) &&
                    this.getRam()==(((Notebook)obj).getRam()) &&
                    this.getDiagonal()==(((Notebook)obj).getDiagonal());
        }
        return false;
    }
}
