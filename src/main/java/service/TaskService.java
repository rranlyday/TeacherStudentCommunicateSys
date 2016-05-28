package service;

import model.Task;

import java.util.List;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
public interface TaskService {
    int buildTask(Integer publisherId,Integer problemSquareId, String taskTitle, String taskDecription);

    int deleteTaskById(int taskId);

    int updateTaskSelectiveById(int taskId,String taskTitle, String taskDecription);

    List<Task> searchTaskByProblemSquareId(Integer problemSquareId,Integer curPage,Integer pageSize);

    Task searchTaskById(int id);
}
