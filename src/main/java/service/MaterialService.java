package service;

import model.Material;

import java.util.List;

/**
 * Created by Administrator on 2016/5/26 0026.
 */
public interface MaterialService {

    int uploadMaterial(Integer uploadUserId,Integer problemSquareId, String materialName, String storageAddress);

    int deleteMaterial(int materialId);

    List<Material> searchMaterialByProblemSquareId(Integer problemSquareId,Integer curPage,Integer pageSize);

    Material searchMaterialById(int id);

}
