package Datebase;

public interface RecordOperations<T extends Recordable> {
    void add(T record);
    void delete(String id);
    T find(String id);
    void addRecords(T record);
}
