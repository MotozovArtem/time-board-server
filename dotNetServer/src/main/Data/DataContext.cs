using Microsoft.EntityFrameworkCore;
using TimeBoard.WebAPI.Models;

namespace TimeBoard.WebAPI.Data
{
    public class DataContext : DbContext
    {
        public DataContext(DbContextOptions<DataContext> options) : base(options)
        {

        }

        public virtual DbSet<Account> Account { get; set; }
        public virtual DbSet<GroupTask> GroupTask { get; set; }
        public virtual DbSet<ProjectSchema> ProjectSchema { get; set; }
        public virtual DbSet<WebAPI.Models.Task> Task { get; set; }
        public virtual DbSet<TaskAttachment> TaskAttachment { get; set; }


        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.HasPostgresExtension("uuid-ossp");

            modelBuilder.Entity<Account>(entity =>
            {
                entity.ToTable("account");

                entity.Property(e => e.Id)
                    .HasColumnName("id")
                    .HasMaxLength(36);

                entity.Property(e => e.CreationDate)
                    .HasColumnName("creation_date")
                    .HasColumnType("date");

                entity.Property(e => e.Email)
                    .IsRequired()
                    .HasColumnName("email")
                    .HasMaxLength(256);

                entity.Property(e => e.FirstName)
                    .IsRequired()
                    .HasColumnName("first_name")
                    .HasMaxLength(256);

                entity.Property(e => e.IconUrl).HasColumnName("icon_url");

                entity.Property(e => e.Login)
                    .IsRequired()
                    .HasColumnName("login")
                    .HasMaxLength(256);

                entity.Property(e => e.Password)
                    .IsRequired()
                    .HasColumnName("password")
                    .HasMaxLength(100);

                entity.Property(e => e.SecondName)
                    .IsRequired()
                    .HasColumnName("second_name")
                    .HasMaxLength(256);

                entity.Property(e => e.Version).HasColumnName("version");
            });

            modelBuilder.Entity<GroupTask>(entity =>
            {
                entity.ToTable("group_task");

                entity.Property(e => e.Id)
                    .HasColumnName("id")
                    .HasMaxLength(36);

                entity.Property(e => e.Name)
                    .IsRequired()
                    .HasColumnName("name")
                    .HasMaxLength(100);

                entity.Property(e => e.Version).HasColumnName("version");
            });

            modelBuilder.Entity<ProjectSchema>(entity =>
            {
                entity.ToTable("project_schema");

                entity.Property(e => e.Id)
                    .HasColumnName("id")
                    .HasMaxLength(36);

                entity.Property(e => e.Account)
                    .IsRequired()
                    .HasColumnName("account")
                    .HasMaxLength(36);

                entity.Property(e => e.ProjectSchema1)
                    .IsRequired()
                    .HasColumnName("project_schema")
                    .HasMaxLength(100);

                entity.Property(e => e.UserInProject)
                    .HasColumnName("user_in_project")
                    .HasMaxLength(36);

                entity.Property(e => e.Version).HasColumnName("version");

                entity.HasOne(d => d.AccountNavigation)
                    .WithMany(p => p.ProjectSchema)
                    .HasForeignKey(d => d.Account)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_project_schema__account");
            });

            modelBuilder.Entity<WebAPI.Models.Task>(entity =>
            {
                entity.ToTable("task");

                entity.Property(e => e.Id)
                    .HasColumnName("id")
                    .HasMaxLength(36);

                entity.Property(e => e.Account)
                    .IsRequired()
                    .HasColumnName("account")
                    .HasMaxLength(36);

                entity.Property(e => e.CreationDate)
                    .HasColumnName("creation_date")
                    .HasColumnType("date");

                entity.Property(e => e.Description).HasColumnName("description");

                entity.Property(e => e.DoneDate)
                    .HasColumnName("done_date")
                    .HasColumnType("date");

                entity.Property(e => e.GroupTask)
                    .HasColumnName("group_task")
                    .HasMaxLength(36);

                entity.Property(e => e.IsDone).HasColumnName("is_done");

                entity.Property(e => e.Name)
                    .IsRequired()
                    .HasColumnName("name")
                    .HasMaxLength(100);

                entity.Property(e => e.Version).HasColumnName("version");

                entity.HasOne(d => d.AccountNavigation)
                    .WithMany(p => p.Task)
                    .HasForeignKey(d => d.Account)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_task__account");

                entity.HasOne(d => d.GroupTaskNavigation)
                    .WithMany(p => p.Task)
                    .HasForeignKey(d => d.GroupTask)
                    .HasConstraintName("FK_task__group");
            });

            modelBuilder.Entity<TaskAttachment>(entity =>
            {
                entity.ToTable("task_attachment");

                entity.Property(e => e.Id)
                    .HasColumnName("id")
                    .HasMaxLength(36);

                entity.Property(e => e.AttachmentName)
                    .IsRequired()
                    .HasColumnName("attachment_name")
                    .HasMaxLength(256);

                entity.Property(e => e.Task)
                    .IsRequired()
                    .HasColumnName("task")
                    .HasMaxLength(36);

                entity.Property(e => e.Url)
                    .IsRequired()
                    .HasColumnName("url")
                    .HasMaxLength(256);

                entity.Property(e => e.Version).HasColumnName("version");

                entity.HasOne(d => d.TaskNavigation)
                    .WithMany(p => p.TaskAttachment)
                    .HasForeignKey(d => d.Task)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_task_attachment__task");
            });

        }
    }
}
