package service.impl;

import dao.MaterialMapper;
import model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.MaterialService;
import util.TimeUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/26 0026.
 */
@Service("materialService")
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialMapper materialMapper;

    public int uploadMaterial(Integer uploadUserId, Integer problemSquareId, String materialName, String storageAddress) {
        Material material = new Material();
        material.setUploadUserId(uploadUserId);
        material.setProblemSquareId(problemSquareId);
        material.setMaterialName(materialName);
        material.setStorageAddress(storageAddress);

        Date uploadTime = TimeUtil.getNowSysTime();
        material.setUploadTime(uploadTime);

        int row =  materialMapper.insertSelective(material);
        return  material.getId();
    }

    public int deleteMaterial(int materialId) {
        return materialMapper.deleteByPrimaryKey(materialId);
    }

    public List<Material> searchMaterialByProblemSquareId(Integer problemSquareId, Integer curPage, Integer pageSize) {
        int beginPos = curPage*pageSize;
        return materialMapper.searchMaterialByProblemSquareId(problemSquareId,beginPos,pageSize);
    }

    public Material searchMaterialById(int id) {
        return materialMapper.selectByPrimaryKey(id);
    }
}
