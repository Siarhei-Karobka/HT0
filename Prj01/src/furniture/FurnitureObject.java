package furniture;

/**
 * @author OK
 * @since 22.10.2018
 */
public class FurnitureObject {
    private String furnitureName;
    private double furnitureSquare;
    private double furnitureSquareMin;

    /**
     * Constructor for furniture with one square parameter.
     * @param furnitureName
     * @param furnitureSquare
     */
    public FurnitureObject(String furnitureName, double furnitureSquare){
        this.furnitureName = furnitureName;

        if (furnitureSquare <0){
            throw new IllegalArgumentException("Furniture square can't be less than 0");
        } else {
            this.furnitureSquare = furnitureSquare;
            this.furnitureSquareMin = furnitureSquare;
        }
    }

    /**
     * Constructor for "Soft" furniture.
     * @param furnitureName
     * @param furnitureSquareMin
     * @param furnitureSquare
     */
    public FurnitureObject(String furnitureName, double furnitureSquareMin, double furnitureSquare) {
        this.furnitureName = furnitureName;
        if ((furnitureSquare < 0) || (furnitureSquareMin < 0)){
            throw new IllegalArgumentException("Furniture square can't be less than 0");
        } else {
            this.furnitureSquare = furnitureSquare;
            this.furnitureSquareMin = furnitureSquareMin;
        }
    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public void setFurnitureName(String furnitureName) {
        this.furnitureName = furnitureName;
    }

    public double getFurnitureSquare() {
        return furnitureSquare;
    }

    public void setFurnitureSquare(double furnitureSquare) {
        this.furnitureSquare = furnitureSquare;
    }

    public double getFurnitureSquareMin() {
        return furnitureSquareMin;
    }

    public void setFurnitureSquareMin(double furnitureSquareMin) {
        this.furnitureSquareMin = furnitureSquareMin;
    }

    @Override
    public String toString() {
        if (furnitureSquareMin == furnitureSquare){
            return furnitureName + " (Square " + furnitureSquare + "m^2)";
        } else {
            return furnitureName + " (Square from:" + furnitureSquareMin + "m^2 to:" + furnitureSquare + "m^2)";
        }
    }
}
