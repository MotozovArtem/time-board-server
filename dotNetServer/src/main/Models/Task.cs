using System;
using System.Collections.Generic;
using TimeBoard.WebAPI.Models;

namespace TimeBoard.WebAPI.Models
{
    public partial class Task
    {
        public Task()
        {
            TaskAttachment = new HashSet<TaskAttachment>();
        }

        public string Id { get; set; }
        public DateTime CreationDate { get; set; }
        public DateTime? DoneDate { get; set; }
        public bool IsDone { get; set; }
        public string Description { get; set; }
        public string Name { get; set; }
        public string GroupTask { get; set; }
        public string Account { get; set; }
        public int Version { get; set; }

        public virtual Account AccountNavigation { get; set; }
        public virtual GroupTask GroupTaskNavigation { get; set; }
        public virtual ICollection<TaskAttachment> TaskAttachment { get; set; }
    }
}
