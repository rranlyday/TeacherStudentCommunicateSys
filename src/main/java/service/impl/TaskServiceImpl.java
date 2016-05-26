package service.impl;

import dao.TaskMapper;
import model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.TaskService;
import util.TimeUtil;

import java.util.Date;

/**
 * Created by Administrator on 2016/5/25 0025.
 */

@Service("taskService")
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;

    public int buildTask(Integer publisherId, Integer problemSquareId, String taskTitle, String taskDecription) {
        Task task = new Task();
        task.setPulisherId(publisherId);
        task.setProblemSquareId(problemSquareId);
        task.setTaskTitle(taskTitle);
        task.setTaskDecription(taskDecription);

        Date pulishTime = TimeUtil.getNowSysTime();
        task.setPulishTime(pulishTime);

        int row =  taskMapper.insertSelective(task);
        return  task.getId();
    }

    public int deleteTaskById(int taskId) {
        return taskMapper.deleteByPrimaryKey(taskId);
    }

    public int updateTaskSelectiveById(int taskId, String taskTitle, String taskDecription) {
        Task task = new Task();
        task.setId(taskId);
        task.setTaskTitle(taskTitle);
        task.setTaskDecription(taskDecription);

        return taskMapper.updateByPrimaryKey(task);
    }
}
