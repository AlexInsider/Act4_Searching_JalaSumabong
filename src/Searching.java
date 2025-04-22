public class Searching {
	public int LinearSearch(int arr[], int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}

		return -1;
	}

	public int BinarySearch(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}

	public int JumpSearch(int arr[], int target) {
		int n = arr.length;
		int step = (int) Math.sqrt(n);
		int prev = 0;

		while (arr[Math.min(step, n) - 1] < target) {
			prev = step;
			step += (int) Math.sqrt(n);

			if (prev >= n) {
				return -1;
			}
		}

		for (int i = prev; i < Math.min(step, n); i++) {
			if (arr[i] == target) {
				return i;
			}
		}

		return -1;
	}

	public int BinarySearch(int[] arr, int target, int low, int high) {

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}

	public int ExponentialSearch(int[] arr, int target) {
		if (arr[0] == target) {
			return 0;
		}

		int i = 1;
		while (i < arr.length && arr[i] <= target) {
			i *= 2;
		}

		return BinarySearch(arr, target, i / 2, Math.min(i, arr.length - 1));
	}
}