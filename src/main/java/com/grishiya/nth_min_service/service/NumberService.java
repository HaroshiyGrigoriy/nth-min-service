package com.grishiya.nth_min_service.service;

import com.grishiya.nth_min_service.exception.InvalidNAppException;
import com.grishiya.nth_min_service.util.ExcelReader;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


@Service
public class NumberService {
    private final ExcelReader reader = new ExcelReader();
    /**
     * Сервис, вычисляющий N-й по величине минимум в столбце Excel-файла.
     *
     * <p>Алгоритм: поддерживаем max-heap размером N.<br>
     * Сложность — O(M log N), где M — количество чисел; память — O(N).</p>
     *
     * @param path абсолютный путь к .xlsx
     * @param n    порядковый номер (начинается с 1)
     * @return N-е минимальное значение, учитывая дубликаты
     * @throws FileNotFoundException   если файл не найден
     * @throws InvalidNAppException    если n < 1 или n > числа в файле
     * @throws IOException             если произошла ошибка чтения Excel
     */
    public int findNthMin(Path path, int n) throws IOException {
        if (!Files.exists(path))
            throw new FileNotFoundException(path.toString());
        List<Integer> nums = reader.readIntegers(path);
        if (n < 1 || n > nums.size()) throw new InvalidNAppException(n, nums.size());
        PriorityQueue<Integer> heap =
                new PriorityQueue<>(Comparator.reverseOrder());
        for (int x : nums) {
            if (heap.size() < n){
            heap.add(x);
            } else if (x < heap.peek()) {
                heap.poll();
                heap.add(x);
            }
        }
        return heap.peek();
    }
}
