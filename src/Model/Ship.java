
package Model;

/**
 *
 * @author Morteza Sarvestani
 */
public class Ship {
    private int RowBegin;
    private int RowFinish;
    private int CulomnBegin;
    private int CulomnFinish;
    private boolean isVertical;
    private boolean isHORIZONTAL;
    private int ShipSize;

    /**
     * @return the RowBegin
     */
    public int getRowBegin() {
        return RowBegin;
    }

    /**
     * @param RowBegin the RowBegin to set
     */
    public void setRowBegin(int RowBegin) {
        this.RowBegin = RowBegin;
    }

    /**
     * @return the RowFinish
     */
    public int getRowFinish() {
        return RowFinish;
    }

    /**
     * @param RowFinish the RowFinish to set
     */
    public void setRowFinish(int RowFinish) {
        this.RowFinish = RowFinish;
    }

    /**
     * @return the CulomnBegin
     */
    public int getCulomnBegin() {
        return CulomnBegin;
    }

    /**
     * @param CulomnBegin the CulomnBegin to set
     */
    public void setCulomnBegin(int CulomnBegin) {
        this.CulomnBegin = CulomnBegin;
    }

    /**
     * @return the CulomnFinish
     */
    public int getCulomnFinish() {
        return CulomnFinish;
    }

    /**
     * @param CulomnFinish the CulomnFinish to set
     */
    public void setCulomnFinish(int CulomnFinish) {
        this.CulomnFinish = CulomnFinish;
    }

    /**
     * @return the isVertical
     */
    public boolean isIsVertical() {
        return isVertical;
    }

    /**
     * @param isVertical the isVertical to set
     */
    public void setIsVertical(boolean isVertical) {
        this.isVertical = isVertical;
    }

    /**
     * @return the isHORIZONTAL
     */
    public boolean isIsHORIZONTAL() {
        return isHORIZONTAL;
    }

    /**
     * @param isHORIZONTAL the isHORIZONTAL to set
     */
    public void setIsHORIZONTAL(boolean isHORIZONTAL) {
        this.isHORIZONTAL = isHORIZONTAL;
    }

    /**
     * @return the ShipSize
     */
    public int getShipSize() {
        return ShipSize;
    }

    /**
     * @param ShipSize the ShipSize to set
     */
    public void setShipSize(int ShipSize) {
        this.ShipSize = ShipSize;
    }

}
