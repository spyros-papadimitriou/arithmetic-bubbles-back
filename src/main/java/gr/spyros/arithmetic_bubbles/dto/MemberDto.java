package gr.spyros.arithmetic_bubbles.dto;

public class MemberDto {
    private long id;
    private int num;
    private OperandDto operand;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public OperandDto getOperand() {
        return operand;
    }

    public void setOperand(OperandDto operand) {
        this.operand = operand;
    }
}
