package meta.pattern.globalEval;

import java.io.IOException;
import java.util.List;

import meta.entity.Pattern;
import meta.pattern.IgFilter;
import meta.transaction.TransactionAug;
import weka.core.Instances;

public class GlobalFrequentPatternEval extends AbstractGlobalEval {
	
	
	
	public GlobalFrequentPatternEval() {
		super();
	}
	
	
	/**
	 * for�����Ƶ�����ȫ��dataset�ϼ����pattern��information gainֵ���������������
	 */
	public void getGlobalSortedPatterns() {
		Instances inss = new Instances(data);
		
		// filter pattern
		List<Pattern> augPatterns = null;
		try {
			 augPatterns = IgFilter.filter(inss, inss, pats, 8);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			inss = TransactionAug.augmentDataset(augPatterns, inss);
			//System.out.println(inss);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*for (Pattern pattern : augPatterns) {
			System.out.println(pattern.pName() + "\t\t\t" + pattern.getGlobalSupport() + "\t\t\t" + pattern.getIg());
		}*/
	}

	
	public static void main(String[] args) {
		GlobalFrequentPatternEval gfpEval = new GlobalFrequentPatternEval();
		gfpEval.getGlobalSortedPatterns();
	}
}