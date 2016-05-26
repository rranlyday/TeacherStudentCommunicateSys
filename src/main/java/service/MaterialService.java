package service;

/**
 * Created by Administrator on 2016/5/26 0026.
 */
public interface MaterialService {

    int uploadMaterial(Integer uploadUserId,Integer problemSquareId, String materialName, String storageAddress);

    int deleteMaterial(int materialId);

}
