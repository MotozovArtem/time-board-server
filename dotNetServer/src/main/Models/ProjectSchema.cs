using System;
using System.Collections.Generic;
using TimeBoard.WebAPI.Models;


namespace TimeBoard.WebAPI.Models
{
    public partial class ProjectSchema
    {
        public string Id { get; set; }
        public string Account { get; set; }
        public string UserInProject { get; set; }
        public string ProjectSchema1 { get; set; }
        public int Version { get; set; }

        public virtual Account AccountNavigation { get; set; }
    }
}
