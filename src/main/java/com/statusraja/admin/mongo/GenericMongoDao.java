package com.statusraja.admin.mongo;

import java.util.List;

import com.statusraja.admin.vo.Categories;
import com.statusraja.admin.vo.FileDetailsVo;
import com.statusraja.admin.vo.Languages;

public interface GenericMongoDao {


	List<Languages> getLanguageList();

	List<Categories> getCategories(String type);

	void saveCategory(FileDetailsVo fIleDetailsVo);

	void saveLanguage(FileDetailsVo fileDetailsVo);

}
