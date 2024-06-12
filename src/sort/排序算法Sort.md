## 1、冒泡排序 BubbleSort

   冒泡排序（Bubble Sort）是一种简单的排序算法，它的基本思想是多次遍历待排序的元素列表，每次遍历都比较相邻的两个元素，并根据比较结果交换它们的位置，
将最大（或最小）的元素逐渐“浮”到正确的位置。这个过程重复执行，直到整个列表排序完成。
以下是冒泡排序的基本思路和解析：

1. **比较相邻元素**：从列表的第一个元素开始，比较它和下一个元素的值。

2. **交换位置**：如果第一个元素的值大于下一个元素的值（如果是升序排序，或小于如果是降序排序），则交换它们的位置。

3. **一轮遍历完成**：完成一轮遍历后，最大（或最小）的元素已经被“冒泡”到列表的末尾。

4. **重复步骤1-3**：重复步骤1和2，但不包括已经排序好的元素（最后一个元素），重复这个过程，直到没有需要交换的元素，或者说，直到列表已经排好序。

5. **完成排序**：一旦没有需要交换的元素，整个列表就被认为是有序的。

## 2、桶排序 BucketSort

1. **确定桶的数量**：首先确定要使用多少个桶来存放待排序的元素。桶的数量可以根据输入数据的特性来选择，通常是取决于元素的范围和数量。

2. **分配元素到桶中**：遍历待排序的元素，将每个元素放入对应的桶中。元素如何分配到桶中通常是通过一个映射函数来确定。

3. **对每个桶进行排序**：对每个桶中的元素进行排序，可以使用任何排序算法，包括插入排序、快速排序等。

4. **合并桶**：将所有桶中的元素按照桶的顺序合并成一个大的有序序列。

## 3、计数排序 CountingSort
计数排序（Counting Sort）是一种线性时间复杂度的排序算法，它适用于对一定范围内的整数或非负整数进行排序。计数排序不是基于比较的排序算法，因此在某些情况下，它可以比比较排序算法（如快速排序或归并排序）更快。

计数排序的基本思想是统计每个输入元素的出现次数，然后根据统计信息将元素排列在正确的位置。下面是计数排序的基本步骤：

1. 找出待排序数组中的最大值（max）和最小值（min）。

2. 创建一个计数数组（counting array），长度为`max - min + 1`，用于存储每个元素的出现次数。

3. 遍历待排序数组，统计每个元素出现的次数，将这些统计数据存储在计数数组中。

4. 根据计数数组的信息，生成已排序数组。遍历计数数组，将每个元素的值恢复到已排序数组中，根据出现次数多次重复相同的元素。

5. 最后，已排序数组即为排序结果。

计数排序的时间复杂度为O(n + k)，其中n是待排序元素的数量，k是元素的范围（最大值与最小值的差加1）。如果k相对于n较小，计数排序可以非常高效。然而，当k较大时，计数排序的空间复杂度也会变得较大，可能不适用于内存有限的情况。

总之，计数排序是一种适用于特定场景的排序算法，特别适用于范围较小且元素分布相对均匀的情况。

## 4、堆排序 HeapSort
堆排序（Heap Sort）是一种基于二叉堆数据结构的排序算法，它的时间复杂度为O(n * log n)，其中n是待排序元素的数量。堆排序是一种不稳定的排序算法，但它对于大规模数据的排序非常高效，因为它是一种原地排序算法。

以下是堆排序的基本步骤和Java示例代码：

### 基本步骤：

1. 构建最大堆（Max Heap）：将待排序的数组视为一棵二叉树，然后从最后一个非叶子节点开始，对树进行堆化操作。堆化操作将确保每个节点都大于或等于其子节点，从而形成最大堆。

2. 交换根节点和最后一个节点：交换堆顶元素（根节点）与数组的最后一个元素，即最大值移到了数组末尾。

3. 缩小堆的范围：将堆的大小减小1，忽略已经排序的最大元素。

4. 重新堆化：对剩余的堆进行重新堆化操作，使其保持最大堆的性质。

5. 重复步骤2到步骤4，直到堆的大小减小到1，排序完成。

### Java示例代码：

```java
public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 构建最大堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 依次取出最大元素并重新堆化
        for (int i = n - 1; i > 0; i--) {
            // 交换堆顶元素和当前堆的最后一个元素
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 重新堆化根节点
            heapify(arr, i, 0);
        }
    }

    // 用于将数组构建成最大堆或重新堆化的辅助方法
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // 比较左子节点和根节点
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 比较右子节点和根节点
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果最大值不是根节点，交换它们，并继续递归堆化
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        heapSort(arr);

        System.out.println("排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

上述代码中，`heapSort` 方法用于执行堆排序，而 `heapify` 方法用于构建最大堆和重新堆化堆。最终，排序完成后的数组将被打印出来。
## 5、插入排序 InsertionSort
插入排序（Insertion Sort）是一种简单且有效的排序算法，特别适用于小型数据集或部分有序的数据。插入排序的基本思想是将待排序的元素插入到已排序部分的合适位置，从而逐步构建一个有序的数组。它的时间复杂度为O(n^2)，其中n是待排序元素的数量。

以下是插入排序的基本步骤和Java示例代码：

### 基本步骤：

1. 从第二个元素开始，将其视为当前元素。

2. 与已排序的元素逐一比较，找到当前元素在已排序部分的正确位置。通常，这是通过逐渐向左移动元素并腾出空间来实现的。

3. 将当前元素插入到已排序部分的正确位置。

4. 重复步骤1到步骤3，直到所有元素都被排序。

### Java示例代码：

```java
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int currentElement = arr[i];
            int j = i - 1;

            // 将当前元素与已排序部分逐一比较并找到正确位置
            while (j >= 0 && arr[j] > currentElement) {
                arr[j + 1] = arr[j];
                j--;
            }

            // 插入当前元素到正确位置
            arr[j + 1] = currentElement;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        insertionSort(arr);

        System.out.println("排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

上述代码中，`insertionSort` 方法用于执行插入排序。它从第二个元素开始，将当前元素插入到已排序部分的正确位置。最终，排序完成后的数组将被打印出来。插入排序是一种稳定的排序算法，它在小规模数据或部分有序数据的情况下表现良好。
## 6、归并排序 MergeSort
归并排序（Merge Sort）是一种分而治之（Divide and Conquer）的排序算法，它将一个大的数组分割成若干个小数组，然后逐步合并这些小数组，最终得到一个有序的数组。归并排序的时间复杂度是O(n * log n)，它是一种稳定的排序算法。

以下是归并排序的基本步骤和一个简单的示例：

### 基本步骤：

1. **分割**：将待排序数组分割为两个大致相等的子数组，直到子数组的长度为1。这可以通过递归实现。

2. **合并**：合并两个子数组，使其成为一个有序的数组。合并过程将两个有序数组合并成一个更大的有序数组。

3. **递归**：重复执行步骤1和步骤2，直到合并所有子数组并得到一个完全有序的数组。

### Java示例代码：

```java
public class MergeSort {
    public static void mergeSort(int[] arr) {
        int n = arr.length;

        if (n > 1) {
            int mid = n / 2;
            int[] leftArray = new int[mid];
            int[] rightArray = new int[n - mid];

            // 分割原数组为左右两个子数组
            for (int i = 0; i < mid; i++) {
                leftArray[i] = arr[i];
            }
            for (int i = mid; i < n; i++) {
                rightArray[i - mid] = arr[i];
            }

            // 递归对左右子数组进行排序
            mergeSort(leftArray);
            mergeSort(rightArray);

            // 合并左右子数组
            merge(arr, leftArray, rightArray);
        }
    }

    private static void merge(int[] arr, int[] leftArray, int[] rightArray) {
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;
        int i = 0, j = 0, k = 0;

        // 合并左右子数组
        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // 处理剩余的元素
        while (i < leftLength) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightLength) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr);

        System.out.println("排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

上述代码中，`mergeSort` 方法用于执行归并排序，而 `merge` 方法用于合并两个有序数组。最终，排序完成后的数组将被打印出来。归并排序是一种高效且稳定的排序算法，适用于各种数据集合。
## 7、快速排序 QuickSort
快速排序（Quick Sort）是一种高效的排序算法，它也是分而治之（Divide and Conquer）的排序算法。快速排序的基本思想是选择一个元素作为基准（通常是数组中的某个元素），然后将比基准小的元素移到基准的左边，比基准大的元素移到基准的右边，最后递归地对左右两个子数组进行排序。它的平均时间复杂度为O(n * log n)，但最坏情况下为O(n^2)。

以下是快速排序的基本步骤和一个示例：

### 基本步骤：

1. **选择基准元素**：从待排序数组中选择一个元素作为基准，通常是第一个或最后一个元素。

2. **分区**：将数组中的其他元素按照与基准的大小关系分为两部分，较小的元素放在基准的左边，较大的元素放在基准的右边。这个过程叫做分区。

3. **递归排序**：递归地对分区后的左子数组和右子数组进行排序，直到子数组的大小为1或0。

4. **合并**：将排序后的左子数组、基准元素和右子数组合并，得到最终的有序数组。

### Java示例代码：

```java
public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            // 递归排序左右子数组
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 选择最后一个元素作为基准
        int i = low - 1; // 初始化索引 i 为 -1

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // 交换 arr[i] 和 arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 交换 arr[i+1] 和 arr[high]
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        quickSort(arr, 0, arr.length - 1);

        System.out.println("排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

上述代码中，`quickSort` 方法用于执行快速排序，而 `partition` 方法用于分区操作。最终，排序完成后的数组将被打印出来。快速排序是一种高效的排序算法，通常比冒泡排序和插入排序快得多。但需要注意，快速排序在最坏情况下的时间复杂度为O(n^2)，因此在实际应用中，可以考虑随机选择基准元素或使用其他改进方法来降低最坏情况的出现概率。
## 8、基数排序 RadixSort
基数排序（Radix Sort）是一种非比较排序算法，它将整数按位数逐个排序。基数排序适用于整数或字符串等数据，它的时间复杂度为O(k * n)，其中k是最大元素的位数，n是元素个数。基数排序通常用于对大量整数进行排序，特别适用于位数相同的整数。

以下是基数排序的基本步骤和一个示例：

### 基本步骤：

1. **确定最大位数**：首先确定待排序元素中最大的位数（最高位数），通常通过遍历数组来确定。

2. **按位排序**：从最低位（个位数）到最高位（最高位数），对数组进行排序，可以使用计数排序或桶排序等方法。

3. **重复排序**：重复进行按位排序，直到所有位数都被排序为止。

4. **合并结果**：最终将排序后的数组合并，得到完全有序的数组。

### Java示例代码：

```java
public class RadixSort {
    public static void radixSort(int[] arr) {
        int max = getMax(arr); // 获取最大元素
        int exp = 1;

        // 对每个位数进行排序
        while (max / exp > 0) {
            countingSortByDigit(arr, exp);
            exp *= 10;
        }
    }

    // 获取数组中的最大元素
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // 使用计数排序对数组按指定位数进行排序
    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // 统计每个数字出现的次数
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // 计算累积次数
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 构建排序结果
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // 将排序结果拷贝回原数组
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);

        System.out.println("排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

上述代码中，`radixSort` 方法用于执行基数排序，而 `countingSortByDigit` 方法用于在指定位数上执行计数排序。最终，排序完成后的数组将被打印出来。基数排序适用于整数排序，尤其是位数相同的整数。
## 9、选择排序 SelectionSort
选择排序（Selection Sort）是一种简单的排序算法，它的基本思想是从未排序部分选择最小（或最大）的元素，然后将其与未排序部分的第一个元素交换，以此类推，直到整个数组有序。选择排序的时间复杂度为O(n^2)，因此对于大型数据集不太高效，但它是一种原地排序算法，不需要额外的内存空间。

以下是选择排序的基本步骤和一个示例：

### 基本步骤：

1. **遍历数组**：从数组的第一个元素开始，遍历到倒数第二个元素。

2. **选择最小元素**：在未排序部分中找到最小的元素，并记录其索引。

3. **交换元素**：将最小元素与未排序部分的第一个元素交换。

4. **重复**：重复步骤1到步骤3，逐渐减小未排序部分的大小，直到整个数组有序。

### Java示例代码：

```java
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // 寻找未排序部分的最小元素
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 将最小元素与未排序部分的第一个元素交换
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);

        System.out.println("排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

上述代码中，`selectionSort` 方法用于执行选择排序。它遍历数组，找到未排序部分的最小元素，然后将其与未排序部分的第一个元素交换。最终，排序完成后的数组将被打印出来。选择排序是一种不太高效的排序算法，但它对于小型数据集或部分有序数据仍然是一个可行的选择。
## 10、希尔排序 ShellSort
希尔排序（Shell Sort）是一种改进的插入排序算法，它通过将数组分成多个子数组，并对这些子数组进行插入排序，从而逐渐减小子数组的规模，最终得到一个有序的数组。希尔排序的时间复杂度取决于所选择的间隔序列，最坏情况下为O(n^2)，但在平均情况下具有较好的性能，通常优于简单的插入排序。

以下是希尔排序的基本步骤和一个示例：

### 基本步骤：

1. **选择间隔序列**：选择一个间隔序列，通常是通过除以2递减获得的。例如，可以选择初始间隔为数组长度的一半，然后逐渐减小间隔。

2. **分组和排序**：将数组分成多个子数组，每个子数组都包含相同间隔的元素。然后对每个子数组执行插入排序。

3. **缩小间隔**：重复步骤1和步骤2，逐渐减小间隔，直到间隔为1。

4. **最后的插入排序**：最后一次间隔为1时，进行插入排序，将整个数组变成有序。

![](E:\CodeSpace\JavaSpace\LearningSpace\Algorithm\src\resources\shell.gif)

### Java示例代码：

```java
public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length;
        
        // 初始间隔为数组长度的一半，然后逐渐减小间隔
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 对每个子数组执行插入排序
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                
                // 插入排序
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 2, 3};
        shellSort(arr);

        System.out.println("排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

上述代码中，`shellSort` 方法用于执行希尔排序，使用不同的间隔序列可以影响性能，但通常选择间隔序列为数组长度的一半是一个不错的起点。
最终，排序完成后的数组将被打印出来。希尔排序是一种相对高效的排序算法，尤其适用于中等大小的数据集。
