using System;
using System.Collections.Generic;

namespace TimeBoard.WebAPI.Models
{
    public partial class GroupTask
    {
        public GroupTask()
        {
            Task = new HashSet<Task>();
        }

        public string Id { get; set; }
        public string Name { get; set; }
        public int Version { get; set; }

        public virtual ICollection<Task> Task { get; set; }
    }
}
