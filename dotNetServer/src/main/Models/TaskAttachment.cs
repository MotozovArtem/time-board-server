using System;
using System.Collections.Generic;

namespace TimeBoard.WebAPI.Models
{
    public partial class TaskAttachment
    {
        public string Id { get; set; }
        public string AttachmentName { get; set; }
        public string Url { get; set; }
        public string Task { get; set; }
        public int Version { get; set; }

        public virtual Task TaskNavigation { get; set; }
    }
}
