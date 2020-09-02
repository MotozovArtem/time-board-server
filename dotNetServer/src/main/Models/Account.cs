using System;
using System.Collections.Generic;
using TimeBoard.WebAPI.Models;

namespace TimeBoard.WebAPI.Models
{
    public partial class Account
    {
        public Account()
        {
            ProjectSchema = new HashSet<ProjectSchema>();
            Task = new HashSet<Task>();
        }

        public string Id { get; set; }
        public string Login { get; set; }
        public string Password { get; set; }
        public string Email { get; set; }
        public string FirstName { get; set; }
        public string SecondName { get; set; }
        public DateTime CreationDate { get; set; }
        public int Version { get; set; }
        public string IconUrl { get; set; }

        public virtual ICollection<ProjectSchema> ProjectSchema { get; set; }
        public virtual ICollection<Task> Task { get; set; }
    }
}
