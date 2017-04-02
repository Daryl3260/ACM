package ds;

/**
 * Created by chenbohua on 2017/4/2.
 */
public class VertexV1<T> {
    private T data=null;
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public VertexV1(){}
    public VertexV1(T data){
        this.data=data;
    }
}
