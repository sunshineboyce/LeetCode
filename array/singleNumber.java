// 给定一个整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
public class ArrayTest{
	
	public static void main(String[] args){
		int[] arrays = {1,2,3,4,5,5,4,3,2};
		singleNumber(arrays);
		singleNumber1(arrays);
	}
	
	/**
	*  第一种方式： ^异或运算符，
	*  时间复杂度：0(n)
	* 运算规则：参与运算的2个对象，如果两个相对位为异，则该位结果为1，否则为0
	* 如：9^5可写成算式如下： 00001001^00000101=00001100 (十进制为12)可见9^5=12 
	**/
	public static void singleNumber(int[] a){
		int num  = 0;
		for(int i = 0 ; i < a.length ; i++){
			num ^= a[i];
		}
		System.out.println(num);
	}
	
	/**
	* 第二种方式：对数组进行排序，使用冒泡方法
	* 时间复杂度： n*(n+1)
	* 再次循环数组，找出单一元素
	**/
	public static void singleNumber1(int[] a){
        int tmp;
        for(int i = 0 ; i < a.length ; i++){
            for(int j = 0 ; j < a.length ; j++){
                if(a[i] > a[j]){
                    tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
        for(int i = 0 ; i < a.length ; i++){
            System.out.println(a[i]);
        }

        for(int i = 1 ; i < a.length ; i+=2){
            if(i == a.length-1){
                System.out.println("没有单一元素");
            }

            if(a[i] != a[i-1]){
                System.out.println("单一元素为："+a[i-1]);
                return;
            }
        }
    }
}