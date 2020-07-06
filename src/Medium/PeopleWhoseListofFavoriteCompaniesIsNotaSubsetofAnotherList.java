package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PeopleWhoseListofFavoriteCompaniesIsNotaSubsetofAnotherList {
	public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
		Set<String>[] set = new Set[favoriteCompanies.size()];
		for (int i = 0; i < set.length; ++i)
			set[i] = new HashSet<>(favoriteCompanies.get(i));
		List<Integer> res = new ArrayList<>();
		outer: for (int i = 0; i < set.length; ++i) {
			for (int j = 0; j < set.length; ++j)
				if (i != j && set[j].containsAll(set[i]))
					continue outer;
			res.add(i);
		}
		return res;
	}
}
