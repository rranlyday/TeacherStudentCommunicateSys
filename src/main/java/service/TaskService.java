package service;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
public interface TaskService {
    int buildTask(Integer publisherId,Integer problemSquareId, String taskTitle, String taskDecription);

    int deleteTaskById(int taskId);

    int updateTaskSelectiveById(int taskId,String taskTitle, String taskDecription);
}
